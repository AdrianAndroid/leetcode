package com.flannery;


import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

// https://blog.csdn.net/baidu_22254181/article/details/82555485

public class WeakDemo {
    // 弱引用队列
    private final static ReferenceQueue<GCTarget> REFERENCE_QUEUE
            = new ReferenceQueue<>();

    public static void main(String[] args) {
        LinkedList<GCTargetWeakReference> gcTargetList = new LinkedList<>();

        // 创建弱引用的对象，一次加入链表中
        for (int i = 0; i < 5; i++) {
            GCTarget gcTarget = new GCTarget(String.valueOf(i));
            GCTargetWeakReference weakReference = new GCTargetWeakReference(gcTarget, REFERENCE_QUEUE);
            gcTargetList.add(weakReference);

            System.out.println("Just created GCTargetWeakReference obj: " +
                    gcTargetList.getLast());
        }

        for (GCTargetWeakReference weakReference : gcTargetList) {
            System.out.println(weakReference);
        }

        Reference<? extends GCTarget> reference;

        while ((reference = REFERENCE_QUEUE.poll()) != null) {
            if (reference instanceof GCTargetWeakReference) {
                GCTargetWeakReference r = (GCTargetWeakReference) (reference);
                System.out.println("In queue, id is: " + r.id + " , " + r.get());
            }
        }

        // 通知gc进行回收
        System.gc();
        try {
            // 休息几分钟，等待上面的垃圾回收线程运行完成
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (GCTargetWeakReference weakReference : gcTargetList) {
            System.out.println(weakReference);
        }


        // 检查关联的引用队列是否为空
        while ((reference = REFERENCE_QUEUE.poll()) != null) {
            if (reference instanceof GCTargetWeakReference) {
                GCTargetWeakReference r = (GCTargetWeakReference) (reference);
                System.out.println("In queue, id is: " + r.id + " , " + r.get());
            }
        }
    }
}

class GCTarget {
    // 对象的ID
    public String id;
    //占用内存空间
    byte[] buffer = new byte[1024];

    public GCTarget(String id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        System.out.println("Finalizing GCTarget, id is : " + id);
    }
}

class GCTargetWeakReference extends WeakReference<GCTarget> {

    String id;

    public GCTargetWeakReference(GCTarget referent) {
        super(referent);
        this.id = referent.id;
    }

    public GCTargetWeakReference(GCTarget referent, ReferenceQueue<? super GCTarget> q) {
        super(referent, q);
        this.id = referent.id;
    }
}

