
public class InjectorTest {
    private Integer number1;
    private Assistant assistant;

    public InjectorTest() {

    }

    /**
     * @return the assistant
     */
    public Assistant getAssistant() {
        return assistant;
    }

    /**
     * @return the number1
     */
    public Integer getNumber1() {
        return number1;
    }

    public static void main(String[] args) throws Exception {
        Injector injector = new Injector();
        Assistant assistant = new Assistant(50000);
        assistant.addPersonToRecommendations("Rojab");
        injector.addDependencies(assistant);
        injector.addDependencies(Integer.valueOf(10));
        InjectorTest injectorTest = new InjectorTest();
        injector.inject(injectorTest);
        System.out.println(injectorTest.getNumber1());
        System.out.println(injectorTest.getAssistant());
    }
}