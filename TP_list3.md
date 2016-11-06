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
