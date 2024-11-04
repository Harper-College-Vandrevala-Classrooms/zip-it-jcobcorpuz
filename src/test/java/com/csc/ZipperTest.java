package com.csc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZipperTest {

  Zipper zipper;

  @BeforeEach
  void setUp() {
    zipper = new Zipper();
  }

  @Test
  void itWorks() {
    assertEquals(true, true);
  }

  @Test
  public void testZipWithEqualSizeLists(){
    List<Integer> nums1 = List.of(1, 3, 5, 7);
    List<Integer> nums2 = List.of(2, 4, 6, 8);
    List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);

    assertEquals(expected, Zipper.zip(nums1, nums2));
  }

  @Test
  public void testZipWithUnequalSizeLists(){
    List<String> colors1 = List.of("Red", "Green", "Blue");
    List<String> colors2 = List.of("White", "Black", "Orange", "Pink");
    List<String> expected = List.of("Red", "White", "Green", "Black", "Blue", "Orange", "Pink");

    assertEquals(expected, Zipper.zip(colors1, colors2));
  }

  @Test
  public void testZipWithEmptyLists(){
    List<Integer> empty1 = List.of();
    List<Integer> empty2 = List.of();
    List<Integer> expected = List.of();

    assertEquals(expected, Zipper.zip(empty1, empty2));
  }

  @Test
  public void testHashmapifyWithEqualSizeLists(){
    List<String> colors = List.of("White", "Black", "Orange", "Pink");
    List<Integer> nums = List.of(1,3,5,7);
    Map<String, Integer> expected = new HashMap<>();
    expected.put("White", 1);
    expected.put("Black", 3);
    expected.put("Orange", 5);
    expected.put("Pink", 7);

    assertEquals(expected, Zipper.hashmapify(colors, nums));
  }

  @Test
  public void testHashmapifyWithUnequalSizeLists(){
    List<String> colors = List.of("White", "Black", "Orange");
    List<Integer> nums = List.of(1, 3, 5, 7);

    assertThrows(IllegalArgumentException.class, () -> {
      Zipper.hashmapify(colors, nums);
    });
  }
}
