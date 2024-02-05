/**
 * Bubblesort algorithm: we check adjacent elements and push the largest element to the end
 * it does swapping of adjacent elements,
 * It is a stable sorting algo &
 * time complexity: O(n^2)
 * @param {number[]} a
 */

function bubbleSort(a) {
  for (let i = 0; i < a.length - 1; i++) {
    let swapped = false;
    for (let j = 0; j < a.length - 1; j++) {
      if (a[j] > a[j + 1]) {
        let temp = a[j];
        a[j] = a[j + 1];
        a[j + 1] = temp;
        swapped = true;
      }
    }
    if (!swapped) {
      break;
    }
  }
}

/**
 * It swaps two numbers of an array
 * @param {number[]} a
 * @param {number} i
 * @param {number} j
 */

function swap(a, i, j) {
  let temp = a[i];
  a[i] = a[j];
  a[j] = temp;
}

/**
 * Selection sort: we place the smallest element in its correct position,
 * It is not a stable algo &
 * Time complexity: O(n^2)
 * @param {number[]} a
 */

function selectionSort(a) {
  for (let i = 0; i < a.length - 1; i++) {
    minIndex = i;
    for (let j = i + 1; j < a.length; j++) {
      if (a[i] > a[j]) {
        minIndex = j;
      }
      swap(a, i, minIndex);
    }
  }
}

const a = [2, 10, 8, 7];

console.log("Before swaping: ", a);
// bubbleSort(a);
selectionSort(a);
console.log("After swaping: ", a);
