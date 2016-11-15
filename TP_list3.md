Technologia programowania

List III

1)

For passing tests

- change RepartBuilder constructor to private

- change getInstance method from public static ReportBuilder getInstance() to public static synchronized ReportBuilder getInstance()

Singleton - enum

Inside ReportBuilder class
- change class to enum

- add term INSTANCE;

- remove constructor

- remove getInstance method

- remove initialize method

Inside ReportBuilderTest

- in testGetSingleton() change getInstance to INSTANCE;

- in measureInitializeTime() remove 2 x ReportBuilder.getInstance();

- in run() change getInstance to INSTANCE;


2)

- download mockito jar form internet and import into adapter project (run test, all should be passed)

1.2


- change ThirdPartyAdapterTest to

@Override
	protected Door createDoorUnderTest() {
//		return new SimpleDoor();
		return new ThirdPartyDoorAdaper();
	}

	@Override
	protected String getDefaultDoorCode() {
//		return SimpleDoor.DEFAULT_DOOR_CODE;
		return ThirdPartyDoor.DEFAULT_CODE;
	}

- create class ThirdPartyDoorAdaper which extends ThirdPartyDoor and implements Door

- add to the class ThirdPartyDoorAdaper
    private String code = DEFAULT_CODE;

    private boolean open = false;
- add methods which require interface Door

- fill the body of methods same as in class SimpleDoor

- run tests ThirdPartyAdapterTest (all should be passed)

  1.3

- create class ThirdPartyDoorObjectAdapter which implement Door

- create public static String DEFAULT_DOOR_CODE = < ThirdPartyDoor class DEFAULT_CODE inside>
and private String code = DEFAULT_DOOR_CODE;
    private boolean open = false;


- put required methods from class SimpleDoor

- change content class ThirdPartyDoorObjectAdapterTest to

@Override
	protected Door createDoorUnderTest() {
//		return new SimpleDoor();
		return new ThirdPartyDoorObjectAdapter();
	}

	@Override
	protected String getDefaultDoorCode() {
//		return SimpleDoor.DEFAULT_DOOR_CODE;
		return ThirdPartyDoor.DEFAULT_CODE;
	}

- run tests ThirdPartyDoorObjectAdapterTest (all should be passed)

3)
- change ReportAssembler, JSONReportBody, XMLReportBody, HTMLReportBody, ReportBody, Report

- create FormatDirector

look -> source code


4)

- create WordCensor

- create WordCensorTest

- create ChainCensorDecoratorTest similar like SocialChannelDecortatorIntegrationTest

- in SocialChannelBuilder create
public SocialChannelBuilder andWith(WordCensor channel) {
		return with(channel);
	}
(necessary for ChainCensorDecoratorTest)

5)

- in class Shape inside asComposite

	if(this instanceof CompositeShape) return (CompositeShape) this;
		 else return null;

- in CompositeShape

inside addShape shapes.add(shape);

inside createShapesList return new ArrayList<Shape>();

inside getShapeCount return shapes.size();

---------------------
 FIRST TEST PASSED
--------------------
 - in CompositeShape

 inside getShapesByType

 List<Shape> rectangleShapes = new ArrayList<Shape>();
		for(Shape s : shapes){
			if(s instanceof Rectangle) rectangleShapes.add(s);
		}
		return rectangleShapes;
---------------------
SECOUND TEST PASSED
---------------------		
- in CompositeShape

	inside removeShape return shapes.remove(shape);

	-------------------
	THIRD TEST PASSED
	-------------------

	-in Shape

		inside move

		if(this instanceof CompositeShape){
			CompositeShape a = (CompositeShape)this;
			for(Shape s : a.shapes){
				s.move(xIncrement, yIncrement);
			}

		}

		-----------------
		FOURTH TEST PASSED
		-----------------

		in CompositeShape


		inside getLeafShapes return shapes;

		-----------------
		FIFTH TEST PASSED
		-----------------
- sixth test is for free

		-----------------
		SIXTH TEST PASSED
		-----------------
6)
	a) b) c) d) paste the code from todos

 e) return ApplianceState.STARTED;


7)

- in ReportGenerator

create

public enum ReportType {
		JSON, XML, HTML, PDF
	}

	comment generateReport

	and add

	public static Report generateReport(ReportData data, ReportType reportType) {
		Report generatedReport;

		switch (reportType) {
			case JSON:
				generatedReport = new JSONReport();
				break;
			case XML:
				generatedReport = new XMLReport();
				break;
			case HTML:
				generatedReport = new HTMLReport();
				break;
			case PDF:
				generatedReport = new PDFReport();
				break;
			default: generatedReport = null;
		}
			generatedReport.generateReport(data);
		return generatedReport;
	}

-check tests

8) 

 	Short introduction: 
The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes. Most simply The abstract factory is an object that has multiple factory methods on it.

With the Factory pattern, you produce implementations (Apple, Banana, Cherry, etc.) of a particular interface -- say, IFruit.

With the Abstract Factory pattern, you produce implementations of a particular Factory interface -- e.g., IFruitFactory. Each of those knows how to create different kinds of fruit.

https://www.tutorialspoint.com/design_pattern/abstract_factory_pattern.htm


 - right mouse clict to eu.jpereira.trainings... -> Diagram -> show Diagram

 there is everything clear

- create AbstractFactiry, ReportBodyFactory, ReportHeaderFactory and ReportFooterFactory -> look source code

- comment everything in class Report and add method

 public static AbstractFactory getFactory(String choice){
		switch(choice){
			case "Body": return new ReportBodyFactory();
			case "Header": return new ReportHeaderFactory();
			case "Footer": return new ReportFooterFactory();
			default: return null;
		}
	}

- change tests -> look source code



9)

	Short introduction:

Facade pattern hides the complexities of the system and provides an interface to the client using which the client can access the system. This type of design pattern comes under structural pattern as this pattern adds an interface to existing system to hide its complexities.

more -> https://www.tutorialspoint.com/design_pattern/facade_pattern.htm


 - add to BookStoreFacade 5 methods: setCustomerService, setWarehouseService, setBookService, setBookService and setNotificationService

 - create DefaultBookstoreFacade create all neseccary objects CustomerDBService... 

implement placeOrder method and simple 5 set methods for the rest required methods

- inside Book add filed String isbn

 - inside Customer add Constructoe and field customerId

 - inside BookStoreFacadeTest create function createFacade

 - all test should be passed


10)

 - Download JMeter unzip and paste to project directory, go to JMeter/bin and do ./jmeter open there WorkBeanch.jmx and  select 1000 thread and do Ctrl + r in the same time do in terminal jconsole and watch

 - in FakeWeatherService do TODO in readStationController method

 - FakeWeatherStationControllerFactory uncomment method WeatherStationController

 - run tests

 - run jmeter and jconsole and see difference 


11) PART I (prototype)

 - in Vehicle class implement clone method

 - write test in SimpleVehicleBuilderTest (testCloneMethod)
