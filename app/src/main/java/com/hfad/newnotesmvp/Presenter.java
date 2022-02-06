package com.hfad.newnotesmvp;

public class Presenter implements IContract.IPresenter {

    IContract.IView myMVPView;

    public Presenter(IContract.IView myMVPView) {
        this.myMVPView = myMVPView;

    }


    @Override
    public void clickedOnButton() {

    }
}
