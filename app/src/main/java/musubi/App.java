/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package musubi;

import processing.core.PApplet;

public class App extends PApplet {
  public void settings() {
    size(400, 400);
  }

  public void setup() {
    background(255);
  }

  public void draw() {
    ellipse(mouseX, mouseY, 20, 20);
  }

  public static void main(String[] args) {
    PApplet.main("musubi.App");
  }
}