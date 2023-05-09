package com.example;

import java.util.function.Function;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Button;

public class View {
    public static TableView getScene() {
        TableView table = new TableView<>();

        table.getColumns().addAll(
            View.<Person, Integer>createColumn("id", "id"),
            View.<Person, String>createColumn("firstname", "firstname"),
            View.<Person, String>createColumn("lastname", "lastname"),
            View.<Person>createButtonColumn("action", "...",)
        );

        for (int i = 0; i < 25; ++i) {
            table.getItems().add(new Person(i, "Name " + i, "Test"));
        }

        return table;
    }

    /**
     * @param <T> the general column type (Car, Person, etc...)
     * @param <U> the property type (String, Integer, ...)
     * @param columnName   the column name
     * @param propertyName the name of the method to call in the column type
     *                     like "id" would call getId() on the object.
     */
    public static <T, U> TableColumn<T, U> createColumn(String columnName, String propertyName) {
        TableColumn<T, U> column = new TableColumn<>(columnName);
        column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return column;
    }
}
