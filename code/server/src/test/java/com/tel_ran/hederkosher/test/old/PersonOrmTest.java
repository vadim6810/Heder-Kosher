package com.tel_ran.hederkosher.test.old;

public class PersonOrmTest {
//    private static final int N_PERSONS = 10;
//    private static final int N_PRODUCTS = 10;
//    static AbstractApplicationContext ctx;
//    static PersonOrm orm;
//
//    List<Person> personList = new LinkedList<>();
//    List<Product> productList= new LinkedList<>();
//
//    @BeforeClass
//    public static void beforeClass() throws Exception {
//        ctx = new FileSystemXmlApplicationContext("beans.xm");
//        orm = ctx.getBean(PersonOrm.class);
//    }
//
//    @AfterClass
//    public static void AfterClass() throws Exception {
//        orm.deleteAll();
//        ctx.close();
//    }
//
//    @Before
//    public void before() throws Exception {
//        for (int i = 0; i < N_PERSONS; i++) {
//            personList.add(new Person(i,"Person "+i));
//        }
//        for (int i = 0; i < N_PRODUCTS; i++) {
//            productList.add(new Product(i,"Product "+i));
//        }
//
//        for (int i = 0; i < N_PERSONS; i++) {
//            orm.addPerson(personList.get(i));
//        }
//        for (int i = 0; i < N_PRODUCTS; i++) {
//            orm.addProduct(productList.get(i));
//        }
//    }
//
//    @After
//    public void after() throws Exception {
////        orm.deleteAll();
//    }
//
//    @Test
//    public void testAddPerson() throws Exception {
////        assertTrue(orm.addPerson(new Person(N_PERSONS,"Person "+N_PERSONS)));
//        assertFalse(orm.addPerson(new Person(N_PERSONS,"Person "+N_PERSONS)));
//    }
//
//    @Test
//    public void testAddProduct() throws Exception {
////        assertTrue(orm.addProduct(new Product(N_PRODUCTS,"Product "+N_PRODUCTS)));
//        assertFalse(orm.addProduct(new Product(N_PRODUCTS,"Product "+N_PRODUCTS)));
//    }
//
//    @Test
//    public void testSetOwnerShip() throws Exception {
//        int testId= 1;
//        //saving products to person owner
//        Person person = personList.get(testId);
//        List<Long> barcodes = new LinkedList<>();
//        barcodes.add(1l);
//        barcodes.add(3l);
//        barcodes.add(5l);
//        List<Product> products = new LinkedList<>();
//        products.add(productList.get(1));
//        products.add(productList.get(3));
//        products.add(productList.get(5));
//        orm.updateOwnerShip(person.getId(),barcodes);
//
//        //getting products from person owner
//        List<Product> productsDB = orm.getOwnedProducts(testId);
//        assertNotNull(productsDB);
//        assertTrue(products.size()==productsDB.size());
//        assertArrayEquals(products.toArray(),productsDB.toArray());
//    }
//
//    @Test
//    public void testSetRentShip() throws Exception {
//        int testId= 2;
//        //saving products to person rent
//        Person person = personList.get(testId);
//        List<Long> barcodes = new LinkedList<>();
//        barcodes.add(0l);
//        barcodes.add(1l);
//        barcodes.add(2l);
//        barcodes.add(3l);
//        List<Product> products = new LinkedList<>();
//        products.add(productList.get(0));
//        products.add(productList.get(1));
//        products.add(productList.get(2));
//        products.add(productList.get(3));
//        orm.updateRentShip(person.getId(),barcodes);
//
//        //getting products from person rent
//        List<Product> productsDB = orm.getRentedProducts(testId);
//        assertNotNull(productsDB);
//        assertTrue(products.size()==productsDB.size());
//        assertArrayEquals(products.toArray(),productsDB.toArray());
//    }
//
//    @Test
//    public void testGetOwners() throws Exception {
//        int personId1 = 1;
//        int personId2 = 2;
//        long barcode = 1l;
//
//        List<Long> barcodes = new LinkedList<>();
//        barcodes.add(barcode);
//
//        Person person1 = personList.get(personId1);
//        Person person2 = personList.get(personId2);
//
//        orm.updateOwnerShip(personId1,barcodes);
//        orm.updateOwnerShip(personId2,barcodes);
//
//        List<Person> persons = orm.getOwners(barcode);
//        assertTrue(persons.size()==2);
//        assertTrue(persons.contains(person1));
//        assertTrue(persons.contains(person2));
//    }
//
//    @Test
//    public void testGetRentees() throws Exception {
//        int personId1 = 3;
//        int personId2 = 4;
//        long barcode = 4l;
//
//        List<Long> barcodes = new LinkedList<>();
//        barcodes.add(barcode);
//
//        Person person1 = personList.get(personId1);
//        Person person2 = personList.get(personId2);
//
//        orm.updateRentShip(personId1,barcodes);
//        orm.updateRentShip(personId2,barcodes);
//
//        List<Person> persons = orm.getRentees(barcode);
//        assertTrue(persons.size()==2);
//        assertTrue(persons.contains(person1));
//        assertTrue(persons.contains(person2));
//    }
//
//    @Test
//    public void testGetOwnedProducts() throws Exception {
//        long productId1 = 5;
//        long productId2 = 6;
//        int personId = 5;
//
//
//        List<Long> productsBarCodes = new LinkedList<>();
//        productsBarCodes.add(productId1);
//        productsBarCodes.add(productId2);
//
//        Product product1 = productList.get((int) productId1);
//        Product product2 = productList.get((int) productId2);
//
//        orm.updateOwnerShip(personId,productsBarCodes);
//
//        List<Product> productsOrm = orm.getOwnedProducts(personId);
//        assertTrue(productsOrm.size()==2);
//        assertTrue(productsOrm.contains(product1));
//        assertTrue(productsOrm.contains(product2));
//    }
//
//    @Test
//    public void testGetRentedProducts() throws Exception {
//        long productId1 = 7;
//        long productId2 = 8;
//        int personId = 6;
//
//
//        List<Long> productsBarCodes = new LinkedList<>();
//        productsBarCodes.add(productId1);
//        productsBarCodes.add(productId2);
//
//        Product product1 = productList.get((int) productId1);
//        Product product2 = productList.get((int) productId2);
//
//        orm.updateRentShip(personId,productsBarCodes);
//
//        List<Product> productsOrm = orm.getRentedProducts(personId);
//        assertTrue(productsOrm.size()==2);
//        assertTrue(productsOrm.contains(product1));
//        assertTrue(productsOrm.contains(product2));
//    }
//
} 
