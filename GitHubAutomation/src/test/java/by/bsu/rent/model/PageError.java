package by.bsu.rent.model;

import java.util.Objects;

public class PageError {
    private String errorDescription;

    public PageError(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageError pageError = (PageError) o;
        return Objects.equals(errorDescription, pageError.errorDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errorDescription);
    }
}