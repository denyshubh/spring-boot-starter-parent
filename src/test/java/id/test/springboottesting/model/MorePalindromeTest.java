package id.test.springboottesting.model;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MorePalindromeTest
{

  private final Palindrome p = new Palindrome();

  @Test
  public void almostPalindrome()
  {
    assertFalse(p.isPalindrome("streets"));
  }

}
