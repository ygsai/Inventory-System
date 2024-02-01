/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package frontend;

/**
 *
 * @author yugoslavia
 */
public interface Loop {//this interface is made for opening a parent window when closing a child one, instead of closing the whole program
    public Loop getParentLoop();
    public void setParentLoop(Loop loop);
}
