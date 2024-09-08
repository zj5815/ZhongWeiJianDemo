package com.demo;

/**
 * @author zwj
 * @date 2024/8/29 19:34
 * @desc
 */
public abstract class AbstractHandleRepeat {

    //重复次数
    private static  Integer REPEAT_TIME = 3;


    public void handel(String inputStr){
        String lowerInputStr = inputStr.toLowerCase();
        //校验
        checkInput(lowerInputStr);
        //处理
        handleRepeat(inputStr);
    }

    private void handleRepeat(String inputStr){
        HandleIndex handleIndex = new HandleIndex();
        if(checkRepeat(inputStr,handleIndex)){
            String result = handleInput(inputStr,handleIndex);
            handleRepeat(result);
        }else{
            return;
        }
    }

    public abstract String handleInput(String inputStr,HandleIndex handleIndex);
    /**
     * 检查
     * @param inputStr
     */
    private void checkInput(String inputStr){
        int index = 0;
        for(int i = 0; i< inputStr.length(); i++){
            char ch = inputStr.charAt(index);
            if('a' <= ch && 'z' >= ch){
                index++;
            }else {
                throw new RuntimeException("输入有误");
            }
        }
    }

    /**
     * 校验重复
     * @param inputStr
     * @param handleIndex
     * @return
     */
    private boolean checkRepeat(String inputStr,HandleIndex handleIndex){
        int index = 0;
        for(int i = index; i < inputStr.length(); i++){
            int repeatTimes = 1;
            for(int j = i+1; j < inputStr.length(); j++){
                if((inputStr.charAt(i) != inputStr.charAt(j)) || j == inputStr.length()-1){
                    //最后一个相同
                    if(inputStr.charAt(i) == inputStr.charAt(j)){
                        repeatTimes++;
                        j++;
                    }
                    if(repeatTimes >= REPEAT_TIME){
                        handleIndex.setStartIndex(i);
                        handleIndex.setEndIndex(j - 1);
                        return true;
                    }else {
                        break;
                    }
                }else {
                    repeatTimes++;
                }
            }
            index++;
        }
        return false;
    }


    class HandleIndex{

        private int startIndex = 0;

        private int endIndex = 0;


        public int getStartIndex() {
            return startIndex;
        }

        public void setStartIndex(int startIndex) {
            this.startIndex = startIndex;
        }

        public int getEndIndex() {
            return endIndex;
        }

        public void setEndIndex(int endIndex) {
            this.endIndex = endIndex;
        }
    }
}