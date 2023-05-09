package com.example;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class Sorter {
    public ArrayList<String> columns;
    public ArrayList<ArrayList<Object>> rows;

    public Sorter() {
        this.columns = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public Sorter withHeader(String... columns) {
        this.columns.addAll((new ArrayList<>(Arrays.asList(columns))));
        return this;
    }

    public Sorter withRow(ArrayList<Object> row) {
        this.rows.add(row);
        return this;
    }

    public Sorter withRow(Object... row) {
        this.rows.add(new ArrayList<>(Arrays.asList(row)));
        return this;
    }

    // index is the column index ("id", "firstname", "age", etc...)
    public void sort(int index) {
        sort(index, true);
    }

    public void sort(int index, boolean ascending) {
        int direction = ascending ? 1 : -1;

        Comparator<ArrayList<Object>> comparator = (row1, row2) -> {
            var a = row1.get(index);
            var b = row2.get(index);

            // Cast to type and compare
            if (a instanceof Integer) {
                return ((Integer)a).compareTo((Integer)b) * direction;
            }
            if (a instanceof Double) {
                return ((Double)a).compareTo((Double)b) * direction;
            }
            if (a instanceof String) {
                return ((String)a).compareTo((String)b) * direction;
            }
            if (a instanceof Date) {
                return ((Date)a).compareTo((Date)b) * direction;
            }
            return 0;
        };

        rows.sort(comparator);
    }

    public String toString() {
        var out = "";
        for (var row : rows) {
            for (var field : row) {
                out += field.toString() + ",";
            }
            out += "\n";
        }

        return out;
    }
}
