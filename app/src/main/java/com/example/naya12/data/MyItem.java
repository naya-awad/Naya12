package com.example.naya12.data;

public class MyItem
{
        private String nameItem;
        private String codeGPSItem;//String because it can start with 0

        public MyItem()
        {
            this.nameItem=nameItem;
            this.codeGPSItem=codeGPSItem;
        }

        public String getNameItem(String name) {
            return nameItem;
        }

        public void setNameItem(String nameItem) {
            this.nameItem = nameItem;
        }

        public String getCodeGPSItem() {
            return codeGPSItem;
        }


        public void setCodeGPSItem(String codeGPSItem) {
            this.codeGPSItem = codeGPSItem;
        }

        @Override
        public String toString() {
            return "MyItem{" +
                    "nameItem='" + nameItem + '\'' +
                    ", codeGPSItem='" + codeGPSItem + '\'' +
                    '}';
        }
    }


