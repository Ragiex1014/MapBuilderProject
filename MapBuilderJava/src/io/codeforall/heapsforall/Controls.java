package io.codeforall.heapsforall;


import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Controls implements KeyboardHandler {

    Player player;
    private boolean isPressed;

    private boolean deletePressed;

    private Grid grid;

    public Controls(Player player,Grid grid){
      this.player = player;
      this.grid = grid;
      init();
    }


    public void init() {
        Keyboard keyboard = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(down);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(left);


        KeyboardEvent paint = new KeyboardEvent();
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        paint.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(paint);

        KeyboardEvent pressed = new KeyboardEvent();
        pressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        pressed.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(pressed);

        KeyboardEvent deletePressed = new KeyboardEvent();
        deletePressed.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        deletePressed.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(deletePressed);

        KeyboardEvent delete = new KeyboardEvent();
        delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        delete.setKey(KeyboardEvent.KEY_C);
        keyboard.addEventListener(delete);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);
        keyboard.addEventListener(save);

        KeyboardEvent clear = new KeyboardEvent();
        clear.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        clear.setKey(KeyboardEvent.KEY_F);
        keyboard.addEventListener(clear);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);
        keyboard.addEventListener(load);
    }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {
         int key = keyboardEvent.getKey();
         switch (key){
             case KeyboardEvent.KEY_UP:
                 player.moveUp();
                 if(isPressed)
                     player.paint();
                 else if(deletePressed)
                     player.erase();
                 break;
             case KeyboardEvent.KEY_DOWN:
                 player.moveDown();
                 if(isPressed)
                     player.paint();
                 else if(deletePressed)
                     player.erase();
                 break;
             case KeyboardEvent.KEY_LEFT:

                 player.moveLeft();
                 if(isPressed)
                     player.paint();
                 else if(deletePressed)
                     player.erase();
                 break;
             case KeyboardEvent.KEY_RIGHT:

                 player.moveRight();
                 if(isPressed)
                     player.paint();
                 else if(deletePressed)
                     player.erase();
                 break;
             case KeyboardEvent.KEY_SPACE:
                 isPressed = true;
                     player.paint();
                 break;
             case KeyboardEvent.KEY_S:
                 grid.saveFile();
                 break;
             case KeyboardEvent.KEY_F:
                 grid.clearGrid();
                 break;
             case KeyboardEvent.KEY_L:
                 grid.loadFile();
                 break;
             case KeyboardEvent.KEY_C:
                 deletePressed = true;
                 player.erase();
                 break;
         }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        int key = keyboardEvent.getKey();
        switch (key) {
            case KeyboardEvent.KEY_SPACE:
                isPressed = false;
                break;
            case KeyboardEvent.KEY_C:
                deletePressed = false;
                break;
        }
    }
}
