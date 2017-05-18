package com.mingweisamuel.zyra.staticData;

import java.io.Serializable;

/**
 * Represents a single profile icon, missing from docs (therefore cannot be auto-generated).
 */
public class ProfileIcon implements Serializable {

    /* Id. Unique for each profile icon. */
    public final long id;
    /* Image for this icon. */
    public final Image image;

    public ProfileIcon(long id, Image image) {
        this.id = id;
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileIcon that = (ProfileIcon) o;

        if (id != that.id) return false;
        return image != null ? image.equals(that.image) : that.image == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (image != null ? image.hashCode() : 0);
        return result;
    }
}
