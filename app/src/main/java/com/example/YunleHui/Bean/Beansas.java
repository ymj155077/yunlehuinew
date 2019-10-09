package com.example.YunleHui.Bean;

import java.util.List;

public class Beansas {


    private List<DetailsBean> details;

    public List<DetailsBean> getDetails() {
        return details;
    }

    public void setDetails(List<DetailsBean> details) {
        this.details = details;
    }

    public static class DetailsBean {
        /**
         * placeName : 等丰富的范围覆盖无法为访问
         * number : ["http://pyxvmr3fi.bkt.clouddn.com/1181196157104295936","http://pyxvmr3fi.bkt.clouddn.com/1181196157318205440","http://pyxvmr3fi.bkt.clouddn.com/1181196157444034560","http://pyxvmr3fi.bkt.clouddn.com/1181196157364342784","http://pyxvmr3fi.bkt.clouddn.com/1181196157074935808","http://pyxvmr3fi.bkt.clouddn.com/1181196157221736448"]
         */

        private String placeName;
        private List<String> number;

        public String getPlaceName() {
            return placeName;
        }

        public void setPlaceName(String placeName) {
            this.placeName = placeName;
        }

        public List<String> getNumber() {
            return number;
        }

        public void setNumber(List<String> number) {
            this.number = number;
        }
    }
}
