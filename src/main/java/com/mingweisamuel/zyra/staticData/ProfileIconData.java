package com.mingweisamuel.zyra.staticData;

import java.io.Serializable;
import java.util.Map;

/**
 * ProfileIconDataDto, missing from docs (therefore cannot be auto-generated).
 */
public class ProfileIconData implements Serializable {

    /** League version. */
    public final String version;
    /** "profileicon". */
    public final String type;
    /** Map from ProfileIcon ids to ProfileIcons. */
    public final Map<Long, ProfileIcon> data;

    public ProfileIconData(String version, String type, Map<Long, ProfileIcon> data) {
        this.version = version;
        this.type = type;
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProfileIconData that = (ProfileIconData) o;

        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return data != null ? data.equals(that.data) : that.data == null;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }
}
