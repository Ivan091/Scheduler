package edu.model.order;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDateTime;


@Table("Metrix")
@Value
@AllArgsConstructor
public class Order {

    @Id
    @With
    Integer id;

    @Embedded.Empty
    Path path;

    Integer seatsNumber;

    LocalDateTime timeRequest;

    public static Order of(Path path, Integer seatsNumber, LocalDateTime timeRequest) {
        return new Order(null, path, seatsNumber, timeRequest);
    }

    public static String toCSVHeader() {
        return Path.toCSVHeader() + ",SeatsNumber,TimeRequest";
    }

    public String toCSV() {
        return String.format("%s,%s,%s", path.toCSV(), seatsNumber, timeRequest);
    }
}
