package com.serad.creditnote.customerservice.models;


import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

public class BaseEntity implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public <T extends BaseEntity> T id(String id) {
        this.id = id;

        return (T) this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseEntity baseEntity = (BaseEntity) o;
        if (baseEntity.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), baseEntity.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString()
    {
        return "BaseDto{" + "id=" + getId() + "}";
    }
}

