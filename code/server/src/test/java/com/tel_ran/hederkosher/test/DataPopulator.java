package com.tel_ran.hederkosher.test;

import com.tel_ran.hederkosher.model.common.entity.*;
import io.github.benas.randombeans.EnhancedRandomBuilder;
import io.github.benas.randombeans.FieldDefinitionBuilder;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.github.benas.randombeans.api.Randomizer;
import io.github.benas.randombeans.randomizers.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

public class DataPopulator {

    public static final int INSTANCE_NUMBER = 10;

    static Random random = new Random();

    @PersistenceContext(name = "HKSpringHibernate")
    static EntityManager em;
    static EmailRandomizer emailRandomizer = new EmailRandomizer();
    static PhoneNumberRandomizer phoneRandomizer = new PhoneNumberRandomizer();
    static IntRandomizer intRandomizer = new IntRandomizer(INSTANCE_NUMBER);
    static IntRandomizer biggerIntRandomizer = new IntRandomizer(100);
    static EnhancedRandom enhancedRandom = EnhancedRandomBuilder.aNewEnhancedRandomBuilder()
            // Address
            .randomize(FieldDefinitionBuilder.field()
                            .named("country").ofType(String.class).get(),
                    new CountryRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("city").ofType(String.class).get(),
                    new CityRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("street").ofType(String.class).get(),
                    new StreetRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("postalCode").ofType(String.class).get(),
                    new ZipCodeRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("building").ofType(String.class).get(),
                    new RegularExpressionRandomizer("\\d{1,3}"))
            .randomize(FieldDefinitionBuilder.field()
                            .named("apartment").ofType(String.class).get(),
                    new RegularExpressionRandomizer("\\d{1,3}"))

            // Gym
            .randomize(FieldDefinitionBuilder.field()
                            .named("name")
                            .ofType(String.class).get(),
                    new FirstNameRandomizer())

            // Task
            .randomize(FieldDefinitionBuilder.field()
                            .named("description") // .named("name")
                            .inClass(Task.class).ofType(String.class).get(),
                    new ExerciseRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("nIterations").ofType(Integer.class).get(),
                    intRandomizer)
            .randomize(FieldDefinitionBuilder.field()
                            .named("nTries").ofType(Integer.class).get(),
                    intRandomizer)
            .randomize(FieldDefinitionBuilder.field()
                            .named("weight").ofType(Integer.class).get(),
                    biggerIntRandomizer)
            .randomize(FieldDefinitionBuilder.field()
                            .named("time").ofType(Integer.class).get(),
                    biggerIntRandomizer)

/*
            .randomize(FieldDefinitionBuilder.field()
                            .named("").ofType(String.class).get(),
                    new )
*/

            // Person
            .randomize(FieldDefinitionBuilder.field()
                            .named("firstName").named("secondName")
                            .ofType(String.class).get(),
                    new FirstNameRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("lastName").ofType(String.class).get(),
                    new LastNameRandomizer())
            .randomize(FieldDefinitionBuilder.field()
                            .named("passportNo").ofType(String.class).get(),
                    new RegularExpressionRandomizer("\\d{9}"))

//            .randomize(FieldDefinitionBuilder.field().named("id").ofType(Long.class).get(),
//                    new SkipRandomizer())
//            .exclude(FieldDefinitionBuilder.field()
//                    .named("id").get())

            .build();

    public static void main(String[] args) {
/*
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            em.getTransaction().begin();
            em.persist(enhancedRandom.nextObject(Person.class));
            em.getTransaction().commit();
        }
        em.close();
*/
/*
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Address o = enhancedRandom.nextObject(Address.class);
            o.setId(i);
            addresses.add(o);
        }
        System.out.println(addresses);

        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Contact o = enhancedRandom.nextObject(Contact.class);
            o.setId(i);
            if (o.getType() == ContactType.EMAIL)
                o.setValue(emailRandomizer.getRandomValue());
            else if (o.getType() == ContactType.TELEPHONE)
                o.setValue(phoneRandomizer.getRandomValue());
            contacts.add(o);
        }
        System.out.println(contacts);

        List<Gym> gyms = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Gym o = enhancedRandom.nextObject(Gym.class);
            o.setId(i);
            o.setAddress(addresses.get(intRandomizer.getRandomValue()));
            gyms.add(o);
        }
        System.out.println(gyms);
*/
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Person o = enhancedRandom.nextObject(Person.class);
            o.setId(i);
            persons.add(o);
        }
        System.out.println(persons);

        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
//        for (int i = 0; ; i++) {
            Task o = enhancedRandom.nextObject(Task.class);
            o.setId((long) i);
            o.setName(o.getDescription().split("[\\s,]")[0]);
            tasks.add(o);
/*            int commaIdx = o.getDescription().indexOf(',');
            if (commaIdx > 0 && commaIdx < 15)
                break;
*/
        }
        System.out.println(tasks);

        List<Program> programs = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Program o = enhancedRandom.nextObject(Program.class);
            o.setId(i);
            programs.add(o);
        }
        System.out.println(programs);

        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Message o = enhancedRandom.nextObject(Message.class);
            o.setId(i);
            o.setPersonFrom(persons.get(intRandomizer.getRandomValue()));
            int personsToNum = intRandomizer.getRandomValue();
            Set<Person> personsTo = new HashSet<>();
            for (int j = 0; j < personsToNum; j++) {
                personsTo.add(persons.get(intRandomizer.getRandomValue()));
            }
            o.setPersonsTo(personsTo);
            messages.add(o);
        }
        System.out.println(messages);

        List<Office> offices = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Office o = enhancedRandom.nextObject(Office.class);
            o.setId(i);
            offices.add(o);
        }
        System.out.println(offices);

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            Room o = enhancedRandom.nextObject(Room.class);
            o.setId(i);
            rooms.add(o);
        }
        System.out.println(rooms);


/*
        List<HKEntityManager<?>> hkEntityManagers = new ArrayList<>();
        hkEntityManagers.add(new HKEntityManager<Address>());
        hkEntityManagers.add(new HKEntityManager<Contact>());
        hkEntityManagers.add(new HKEntityManager<Gym>());
        hkEntityManagers.add(new HKEntityManager<Message>());
        hkEntityManagers.add(new HKEntityManager<Office>());
        hkEntityManagers.add(new HKEntityManager<Person>());
        hkEntityManagers.add(new HKEntityManager<Program>());
        hkEntityManagers.add(new HKEntityManager<Room>());
        hkEntityManagers.add(new HKEntityManager<Task>());
//        hkEntityManagers.add(new HKEntityManager<>());

        for (HKEntityManager<?> hkEntityManager: hkEntityManagers) {
            new DoWithEM() {
                public <T> run(HKEntityManager<T> HKEntityManager) {
//                    for (T entity : hkEntityManager) {
                        hkEntityManager.generateAndSave(entity);
//                    }
                }.run(hkEntityManager);
            }

*/

/*
        List<>  = new ArrayList<>();
        for (int i = 0; i < INSTANCE_NUMBER; i++) {
            .add(enhancedRandom.nextObject(.class));
        }
        System.out.println();
*/
    }

    static class ExerciseRandomizer implements Randomizer<String> {
        final String[] exerciseTypes = {"Walking", "Tai Chi", "Water Aerobics", "Stretching in General",
                "Jogging", "Zumba or Similar Dance-Based Fitness Class", "Yoga", "Isometrics",
                "Volleyball", "Pole Dancing, for Work or Pleasure", "Skating, Ice or Roller",
                "Water Skiing or other Boat-Assisted Water Sport", "Arm Wrestling", "Baseball",
                "Calisthenics", "Jumping Rope", "BMX Bike-Riding", "Skateboarding", "Surfing",
                "Mountaineering", "Tennis or other Racket Sport", "Canoeing, Kayaking, or other Rowing",
                "Skiing, Snowboarding, or other Snow-Sliding", "Hockey", "Soccer", "Diving",
                "Bicycling (Racing)", "Jumping, High and/ or Far", "Sprinting",
                "Throwing Heavy Objects for Distance", "Sword Fighting (Non-Lethal)", "Basketball",
                "Kung-Fu or Similar Show-Offy Martial Art", "Marathon Running", "Pole Vaulting",
                "Rock Climbing", "Hurdles", "Football", "Powerlifting", "Crossfit", "Boxing",
                "Wrestling", "Triathlons", "Ballet", "MMA", "Gymnastics", "Super Squats"};

        @Override
        public String getRandomValue() {
            return exerciseTypes[random.nextInt(exerciseTypes.length)];
        }
    }

    /*
        static class HKEntityManager<T> {
            void generateAndSave() {

            }
        }

        interface DoWithEM {
            void <T> run(HKEntityManager<T> t);
        }
    */

}
