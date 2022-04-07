package com.flannery;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftDemo {
    public static void main(String[] args) {
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        String str = new String("abc");
        SoftReference<String>softReference = new SoftReference<>(str, referenceQueue);
        str = null;
        System.gc();
        System.out.println(softReference.get());
        Reference reference = referenceQueue.poll();
        System.out.println(reference);
    }
}
