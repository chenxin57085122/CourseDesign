package com.xinyuan.main;

/**
 * @Auther: chenxin
 * @Date: 2019/1/3 21:11
 * @Description:
 */
public class Soluction {

    class Egde {
        private int a;
        private int b;
    }

    boolean isConnected(Egde[] graph, int p, int q) {

        int index = 0;
        for (int i = 0; i < graph.length; i++) {
            if (graph[i] == null) {
                continue;
            }
            if (graph[i].a == p) {
                if (graph[i].b == q) {
                    return true;
                } else {
                    return test(graph, graph[i].b, q) || test(graph,graph[i].a, q);
                }
            }

            if (graph[i].a == q) {
                if (graph[i].b == p) {
                    return true;
                } else {
                    return test(graph, graph[i].b, p) || test(graph,graph[i].b,p);
                }
            }
        }
        return false;
    }

    static boolean test(Egde[] egdes, int index, int target) {

        for (Egde egde : egdes) {
            if (egde != null) {
                if (egde.a == index) {
                    if (egde.b == target) {
                        return true;
                    } else {
                        egde = null;
                        return test(egdes, egde.b, target);
                    }
                }
            }
        }
        return false;
    }
}
