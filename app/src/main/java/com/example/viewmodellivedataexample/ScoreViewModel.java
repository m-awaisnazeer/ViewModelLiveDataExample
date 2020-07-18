package com.example.viewmodellivedataexample;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

                      /* ****ViewModel Without Live Data **** */

    private Integer score;

    public Integer getScore() {
        if (score==null)
            score = 0;
        return score;
    }

    public void addScore(){
        if (score==null)
            score=0;
        score +=1;
    }
    public void resetScore(){
        score =0;
    }


                        /* **** ViewModel with Live Data **** */



    private MutableLiveData<Integer> ScoreLive;

    public MutableLiveData<Integer> getScoreLive() {
        if (ScoreLive ==null){
            ScoreLive = new MutableLiveData<>();
            ScoreLive.setValue(0); //calling from Main thread
       //     score.postValue(0); //calling from Worker thread
        }
        return ScoreLive;
    }

    public void addScoreLive(){
        if (ScoreLive.getValue() != null){
            ScoreLive.setValue(ScoreLive.getValue() +1);
        }
    }
    public void resetScoreLive(){
        ScoreLive.setValue(0);
    }
}
