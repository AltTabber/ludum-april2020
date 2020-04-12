package ru.alttabber.ludum.inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class InputController implements InputProcessor {

    PlayerInput currentPlayerInput = PlayerInput.IDLE;

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.UP:
                currentPlayerInput = PlayerInput.UP;
                break;
            case Input.Keys.DOWN:
                currentPlayerInput = PlayerInput.DOWN;
                break;
            case Input.Keys.LEFT:
                currentPlayerInput = PlayerInput.LEFT;
                break;
            case Input.Keys.RIGHT:
                currentPlayerInput = PlayerInput.RIGHT;
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    public PlayerInput getCurrentPlayerInput() {
        return currentPlayerInput;
    }
}
