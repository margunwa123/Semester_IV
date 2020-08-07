import java.lang.reflect.*;

public class AssistantDecoder {
    private Assistant assistant;

    AssistantDecoder(Assistant assistant) {
        this.assistant = assistant;
    }

    public void addPersonToRecommendations(String name) throws Exception {
        Method addingPerson = assistant.getClass().getDeclaredMethod("addPersonToRecommendations", String.class);
        addingPerson.setAccessible(true);
        addingPerson.invoke(this.assistant, name);
    }

    public int getSalary() throws Exception {
        Field salary = assistant.getClass().getDeclaredField("salary");
        salary.setAccessible(true);
        return salary.getInt(this.assistant);
    }
}