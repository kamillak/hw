package kz.aitu.project.entities;

public class User {
    private int id;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String recovery_question;
    private String question_answer;

    public User() {

    }

    public User(String username, String password, String name, String surname, String recovery_question, String question_answer) {
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setRecovery_question(recovery_question);
        setQuestion_answer(question_answer);
    }

    public User(int id, String username, String password, String name, String surname, String recovery_question, String question_answer) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setName(name);
        setSurname(surname);
        setRecovery_question(recovery_question);
        setQuestion_answer(question_answer);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setRecovery_question(String recovery_question) {
        this.recovery_question = recovery_question;
    }

    public String getRecovery_question() {
        return recovery_question;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public String getQuestion_answer() {
        return question_answer;
    }
}
