package com.est_jpa.estudo_jpa.Order;

import java.time.Instant;
import java.util.UUID;

import com.est_jpa.estudo_jpa.User.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "tb_orders")
public class Order {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;


    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone="GMT")    
    @Column(nullable = false)
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public Order(User client, Instant moment, OrderStatus orderStatus) {
        this.moment = moment;
        this.client = client;
        this.orderStatus = orderStatus;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
