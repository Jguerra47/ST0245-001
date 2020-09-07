/*
* Title: Merge Sort [Source Code]
* Author: baeldung
* Date: December 14, 2018
* Version:
* Availability:https://www.baeldung.com/java-merge-sort
*/
 
/**
* Esta clase ordena una arreglo por mergeSort
*
*
*/
public class MergeSort
{

/*
*Este método divide el arreglo por la mitad
*@param int[]a recibe una arreglo 
*@param n recibe la longitud del arreglo
*/
    public static void mergeSort(int[] a, int n) {
    if (n < 2) {
        return ;
    }
    int mid = n / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];
 
    for (int i = 0; i < mid; i++) {
        l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
        r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);
 
    merge(a, l, r, mid, n - mid);
}

/*
*Est método organiza el arreglo de menor a mayor
*@param int[]a recibe una arreglo 
*@param int[]l el arreglo dividido a la mitad parte izq
*@param int[]r el arreglo dividido a la mitad parte der
*@param left la longitud del arreglo parte izquierda
*@param rigth la longitud del arreglo parte derecha
*/
    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
 
    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
        if (l[i] <= r[j]) {
            a[k++] = l[i++];
        }
        else {
            a[k++] = r[j++];
        }
    }
    while (i < left) {
        a[k++] = l[i++];
    }
    while (j < right) {
        a[k++] = r[j++];
    }
}
}
