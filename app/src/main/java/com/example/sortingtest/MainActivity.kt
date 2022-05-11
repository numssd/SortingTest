package com.example.sortingtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/*
Введите в поле количество чисел в списке, после выберете кнопку  метода соритровки

1) Быстрая сортировка(Quick Sort)
2) Сортировке слиянием(Merge Sort)
3) Сортировка Пирамидальная-Кучей (Heap Sort)
Исходные данные массив, состоящий из пяти тысяч чисел от 0 до 1000
 */

class MainActivity : AppCompatActivity() {
    private var clockBubble = 0
    private var clockInsertions = 0
    private var clockSelection = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var size: Int

        val arrayList = ArrayList<Int>()

        buttonBubbleSort.setOnClickListener {
            if (editTextNumber.text.isEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.write_size_text),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                size = editTextNumber.text.toString().toInt()
                while (arrayList.size < size) {
                    arrayList.add((0..99).random())
                }
                bubbleSort(arrayList)
            }
        }

        buttonInsertionSort.setOnClickListener {
            if (editTextNumber.text.isEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.write_size_text),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                size = editTextNumber.text.toString().toInt()
                while (arrayList.size < size) {
                    arrayList.add((0..99).random())
                }
                insertionSort(arrayList)
            }
        }

        buttonSelectionSort.setOnClickListener {
            if (editTextNumber.text.isEmpty()) {
                Toast.makeText(
                    this@MainActivity,
                    getString(R.string.write_size_text),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                size = editTextNumber.text.toString().toInt()
                while (arrayList.size < size) {
                    arrayList.add((0..99).random())
                }
                selectionSort(arrayList)
            }
        }
    }

    private fun bubbleSort(inputArray: ArrayList<Int>) {
        clockBubble = 0
        val startTime = System.currentTimeMillis()
        val arraySize = inputArray.size
        var temp: Int
        for (i in 0 until arraySize) {
            for (j in 1 until arraySize - i) {
                clockBubble++
                if (inputArray[j - 1] > inputArray[j]) {
                    clockBubble++
                    temp = inputArray[j - 1]
                    inputArray[j - 1] = inputArray[j]
                    inputArray[j] = temp
                }
            }
        }
        val endTime = System.currentTimeMillis()

        timeSort.text = String.format("%d ms", endTime - startTime)

    }

    private fun insertionSort(array: ArrayList<Int>) {
        clockInsertions = 0
        val startTime = System.currentTimeMillis()
        for (i in 1 until array.size) {
            clockInsertions++
            val current = array[i]
            var j = i - 1
            while (j >= 0 && current < array[j]) {
                clockInsertions++
                array[j + 1] = array[j]
                j--
            }
            array[j + 1] = current
        }
        val endTime = System.currentTimeMillis()

        timeSort.text = String.format("%d ms", endTime - startTime)
    }

    private fun selectionSort(array: ArrayList<Int>) {
        clockSelection = 0
        val startTime = System.currentTimeMillis()
        for (i in array.indices) {
            var min = array[i]
            var minId = i
            for (j in i + 1 until array.size) {
                clockSelection++
                if (array[j] < min) {
                    min = array[j]
                    minId = j
                }
            }
            val temp = array[i]
            array[i] = min
            array[minId] = temp
        }
        val endTime = System.currentTimeMillis()

        timeSort.text = String.format("%d ms", endTime - startTime)
    }
}