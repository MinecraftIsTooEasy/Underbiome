package cn.tesseract.underbiome.util;

import net.fabricmc.loader.impl.lib.sat4j.pb.tools.WeightedObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WeightedList<T> {
    private int totalWeight = 0;
    private int[] weights = new int[0];
    private final List<T> list;

    public WeightedList() {
        list = new ArrayList<>();
    }

    public void add(T object) {
        add(object, 1);
    }

    public void add(T object, int weight) {
        list.add(object);
        weights = Arrays.copyOf(weights, weights.length + 1);
        totalWeight += (weights[weights.length - 1] = weight);
    }

    public T get(int index) {
        for (int i = 0; i < weights.length; i++) {
            index -= weights[i];
            if (index < 0)
                return list.get(i);
        }
        return null;
    }

    public T get(float rate) {
        return get((int) (totalWeight * rate));
    }

    public T get(Random rand) {
        return get(rand.nextFloat());
    }

    public T get() {
        return get(new Random());
    }

    public int size() {
        return list.size();
    }

    public int weight() {
        return totalWeight;
    }
}
