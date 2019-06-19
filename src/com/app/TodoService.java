package com.app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class TodoService {
    private static List<Todo> dataStore = new ArrayList<>();
    public static int count = 0;

    public void addTodo(String title) {
        dataStore.add(new Todo(++count, title, LocalDate.now(), false));
    }

    public static <T> List<T> sort(List<T> list, Comparator<T> comparator) {
        return list
                .stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public void editTodo(int id, String newTitle) {
        dataStore.replaceAll(item -> {
            if (item.getId() == id)
                item.setTitle(newTitle);

            return item;
        });
    }

    public void deleteTodo(int id) {
        try {
            if (id > count)
                throw new IllegalAccessException("No such Id");
            dataStore.removeIf(item -> item.getId() == id);
            System.out.println("Todo Deleted " + id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void completeAll() {
        for (Todo el : dataStore)
            el.setCompleted(true);
    }

    public void completeTodo(int id) {
        List<Todo> list = filter(dataStore, e -> e.getId() == id);
        for (Todo el : list)
            el.setCompleted(true);
    }

    public static <T> List<T> remove(List<T> list, Predicate<T> predicate) {
        return list
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void clearCompleted() {
        List<Todo> list = remove(dataStore, e -> e.getCompleted() == true);
        dataStore.removeAll(list);
    }

    public void showAll() {
        for (Todo data : dataStore)
            System.out.println(data.toString());
    }


    public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list
                .stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

//    public List<Todo> filter(){
//        Stream<Todo> resStream = dataStore.stream()
//                .filter(e -> e.getCompleted()==true);
//        List<Todo> list = resStream.collect(Collectors.toList());
//        return list;
//    }
}
