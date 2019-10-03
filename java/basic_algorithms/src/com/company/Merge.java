package com.company;

public class Merge {

  public static void sort(Comparable[] a) {
    Comparable[] aux = new Comparable[a.length];
    sort(a, aux, 0, a.length - 1);
  }

  private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
    if (lo >= hi) return;
    int mid = lo + (hi - lo) / 2;
    sort(a, aux, lo, mid);
    sort(a, aux, mid + 1, hi);
    merge(a, aux, lo, mid, hi);
  }

  private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
    for (int i = 0; i < a.length; i++) {
      aux[i] = a[i];
    }

    int low = lo;
    int high = mid + 1;

    for (int i = 0; i < a.length; i++) {
      if (lo >= mid) a[i] = aux[high++];
      else if (high >= hi) a[i] = aux[low++];
      else if (a[low].compareTo(a[high]) >= 0) a[i] = aux[low++];
      else if (a[high].compareTo(a[low]) < 0) a[i] = aux[high++];
    }
  }
}
