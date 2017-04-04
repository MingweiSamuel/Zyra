package com.mingweisamuel.zyra.entity;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * TODO
 */
public class SummonerEntityCollection extends AbstractCollection<SummonerEntity> {

    private final Set<SummonerEntity> summonerEntities = new HashSet<>();

    @Override
    public Iterator<SummonerEntity> iterator() {
        return summonerEntities.iterator();
    }

    @Override
    public int size() {
        return summonerEntities.size();
    }

    @Override
    public boolean contains(Object o) {
        return summonerEntities.contains(o);
    }

    @Override
    public boolean add(SummonerEntity summonerEntity) {
        return summonerEntities.add(summonerEntity);
    }

    @Override
    public boolean remove(Object o) {
        return summonerEntities.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return summonerEntities.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends SummonerEntity> c) {
        return summonerEntities.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return summonerEntities.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return summonerEntities.retainAll(c);
    }

    @Override
    public void clear() {
        summonerEntities.clear();
    }

    @Override
    public int hashCode() {
        return summonerEntities.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof SummonerEntityCollection)) return false;

        SummonerEntityCollection other = (SummonerEntityCollection) obj;
        return summonerEntities.equals(other.summonerEntities);
    }
}
