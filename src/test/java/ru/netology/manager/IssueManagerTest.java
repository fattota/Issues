package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;

class IssueManagerTest {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    private Issue issue1 = new Issue(1, "Issie1", true, "Smith", Set.of("bug"), "Project1", Set.of("None"), "None", Set.of("None"));
    private Issue issue2 = new Issue(2, "Issue2", false, "Doe", Set.of("bug"), "Project2", Set.of("None"), "Smith", Set.of("None"));
    private Issue issue3 = new Issue(3, "Issue3", true, "Smith", Set.of("bug"), "Project3", Set.of("None"), "Doe", Set.of("None"));
    private Issue issue4 = new Issue(4, "Issue4", false, "Jones", Set.of("document"), "Project4", Set.of("None"), "Doe", Set.of("None"));
    private Issue issue5 = new Issue(5, "Issue5", true, "Taylor", Set.of("bug"), "Project5", Set.of("None"), "Jones", Set.of("None"));
    private Issue issue6 = new Issue(6, "Issue6", true, "Brown", Set.of("bug"), "Project6", Set.of("None"), "Taylor", Set.of("None"));


    @Test
    void shouldSearchClosedIssue() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue1, issue3, issue5, issue6};
        Issue[] actual = manager.searchClose();

        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchOpenIssue() {
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue2, issue4};
        Issue[] actual = manager.searchOpen();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {
        String author = "Smith";
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue1, issue3};
        Issue[] actual = manager.searchByAuthor(author);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthorIfOnly() {
        String author = "Doe";
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue2};
        Issue[] actual = manager.searchByAuthor(author);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNonExistentAuthor() {
        String author = "Hemingway";
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAuthor(author);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAssignee() {
        String assignee = "Doe";

        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue3, issue4};
        Issue[] actual = manager.searchByAssignee(assignee);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAssigneeIfOnly() {
        String assignee = "Smith";
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{issue2};
        Issue[] actual = manager.searchByAssignee(assignee);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldSearchByNonExistentAssignee() {
        String assignee = "Hemingway";
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));

        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByAssignee(assignee);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldCloseById() {
        int idToClose = 2;
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));
        manager.closeById(idToClose);

        Issue[] expected = new Issue[]{issue1, issue2, issue3, issue5, issue6};
        Issue[] actual = manager.searchClose();

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldOpenById() {
        int idToOpen = 3;
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));
        manager.openById(idToOpen);

        Issue[] expected = new Issue[]{issue2, issue3, issue4};
        Issue[] actual = manager.searchOpen();

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldOpenByOpenedId() {
        int idToOpen = 2;
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));
        manager.openById(idToOpen);

        Issue[] expected = new Issue[]{issue2, issue4};
        Issue[] actual = manager.searchOpen();

        assertArrayEquals(expected, actual);


    }


    @Test
    void shouldSearchByNonExistentLabel() {
        String label = "offer";
        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));


        Issue[] expected = new Issue[]{};
        Issue[] actual = manager.searchByLabel(label);

        assertArrayEquals(expected, actual);


    }


    @Test
    void shouldRemoveById() {

        repository.addAll(List.of(issue1, issue2, issue3, issue4, issue5, issue6));
        repository.remove(issue1);


        Issue[] expected = new Issue[]{issue2, issue3, issue4, issue5, issue6};
        Issue[] actual = repository.getAll().toArray(new Issue[0]);

        assertArrayEquals(expected, actual);


    }

    @Test
    void shouldRemoveByAlreadyDeletedId() {

        repository.addAll(List.of(issue2, issue3, issue4, issue5, issue6));
        repository.remove(issue1);


        Issue[] expected = new Issue[]{issue2, issue3, issue4, issue5, issue6};
        Issue[] actual = repository.getAll().toArray(new Issue[0]);

        assertArrayEquals(expected, actual);


    }
}