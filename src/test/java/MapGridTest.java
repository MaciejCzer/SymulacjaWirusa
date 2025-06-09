
import Simulation.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MapGridTest {
    private MapGrid mapGrid;
    private Config config;
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    @BeforeEach
    void setUp() {
        config = mock(Config.class);
        when(config.getDeathRate()).thenReturn(14);
        when(config.getInfectionRate()).thenReturn(30);
        when(config.getImmunityDuration()).thenReturn(30);
        mapGrid = new MapGrid(WIDTH, HEIGHT, config);
    }

    @Test
    void testGridInitialization() {
        assertEquals(WIDTH, mapGrid.getWidth());
        assertEquals(HEIGHT, mapGrid.getHeight());
        assertTrue(mapGrid.getPeople().isEmpty());
        assertTrue(mapGrid.getHospitals().isEmpty());
    }

    @Test
    void testAddPerson() {
        Person person = mock(Person.class);
        mapGrid.addPerson(person);
        assertEquals(1, mapGrid.getPeople().size());
        assertTrue(mapGrid.getPeople().contains(person));
    }

    @Test
    void testAddHospital() {
        Hospital hospital = mock(Hospital.class);
        mapGrid.addHospital(hospital);
        assertEquals(1, mapGrid.getHospitals().size());
        assertTrue(mapGrid.getHospitals().contains(hospital));
    }

    @Test
    void testMovePeople() {
        Person person = mock(Person.class);
        when(person.isAlive()).thenReturn(true);
        mapGrid.addPerson(person);

        mapGrid.movePeople();

        verify(person).move(WIDTH, HEIGHT);
    }

    @Test
    void testInfection() {

        Person infected = mock(Person.class);
        when(infected.isAlive()).thenReturn(true);
        when(infected.isInfected()).thenReturn(true);
        Point infectedPos = new Point(5, 5);
        when(infected.getPosition()).thenReturn(infectedPos);

        Person healthy = mock(Person.class);
        when(healthy.isAlive()).thenReturn(true);
        when(healthy.isInfected()).thenReturn(false);
        when(healthy.isImmune()).thenReturn(false);
        Point healthyPos = new Point(5, 6);
        when(healthy.getPosition()).thenReturn(healthyPos);

        mapGrid.addPerson(infected);
        mapGrid.addPerson(healthy);

        mapGrid.infectPeople();

        verify(healthy, atLeastOnce()).isInfected();
        verify(healthy, atLeastOnce()).isImmune();
    }

    @Test
    void testHealAtHospital() {
        Person infected = mock(Person.class);
        when(infected.isAlive()).thenReturn(true);
        when(infected.isInfected()).thenReturn(true);
        Point pos = new Point(5, 5);
        when(infected.getPosition()).thenReturn(pos);

        Hospital hospital = mock(Hospital.class);
        when(hospital.canHeal(infected)).thenReturn(true);

        mapGrid.addPerson(infected);
        mapGrid.addHospital(hospital);

        mapGrid.healPeople();

        verify(hospital).heal(infected);
    }

    @Test
    void testUpdateTimers() {

        Person immune = mock(Person.class);
        when(immune.isAlive()).thenReturn(true);
        when(immune.isInfected()).thenReturn(false);
        when(immune.isImmune()).thenReturn(true);
        when(immune.getImmunityTime()).thenReturn(31);

        mapGrid.addPerson(immune);
        mapGrid.updateTimer();

        verify(immune).addImmunityTime();
        verify(immune).removeImmunity();
    }
}