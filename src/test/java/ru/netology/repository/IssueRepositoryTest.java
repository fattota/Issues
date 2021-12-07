package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    private IssueRepository repository = new IssueRepository();

    private Issue issue1 = new Issue(1, "Issie1", true, "Smith", Set.of("bug"), Set.of("Project1"), Set.of("None"), Set.of("None"), Set.of("None"));
    private Issue issue2 = new Issue(2, "Issue2", false, "Doe", Set.of("bug"), Set.of("Project2"), Set.of("None"), Set.of("Smith"), Set.of("None"));
    private Issue issue3 = new Issue(3, "Issue3", true, "Smith", Set.of("bug"), Set.of("Project3"), Set.of("None"), Set.of("Doe"), Set.of("None"));
    private Issue issue4 = new Issue(4, "Issue4", false, "Jones", Set.of("document"), Set.of("Project4"), Set.of("None"), Set.of("Doe"), Set.of("None"));
    private Issue issue5 = new Issue(5, "Issue5", true, "Taylor", Set.of("bug"), Set.of("Project5"), Set.of("None"), Set.of("Jones"), Set.of("None"));
    private Issue issue6 = new Issue(6, "Issue6", true, "Brown", Set.of("bug"), Set.of("Project6"), Set.of("None"), Set.of("Taylor"), Set.of("None"));


    @Test
    void shouldGetAll() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue1, issue2, issue3, issue4, issue5, issue6};
        Issue[] actual = repository.getAll().toArray(new Issue[0]);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldAdd() {
        repository.add(issue1);
        repository.add(issue2);
        repository.add(issue3);

        Issue[] expected = new Issue[]{issue1, issue2, issue3};
        Issue[] actual = repository.getAll().toArray(new Issue[0]);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemove() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));
        repository.remove(issue1);

        Issue[] expected = new Issue[]{issue2, issue3, issue4, issue5, issue6};
        Issue[] actual = repository.getAll().toArray(new Issue[0]);

        assertArrayEquals(expected, actual);

    }

}