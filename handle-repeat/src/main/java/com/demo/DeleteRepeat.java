package com.demo;

/**
 * @author zwj
 * @date 2024/8/29 19:42
 * @desc
 */
public class DeleteRepeat extends AbstractHandleRepeat {

    public String handleInput(String inputStr, HandleIndex handleIndex) {
        StringBuilder inputBuilder = new StringBuilder(inputStr);
        int startIndex = handleIndex.getStartIndex();
        //stringBuilder 不包含endIndex
        int endIndex = handleIndex.getEndIndex() + 1;

        if(endIndex == inputStr.length()){
            endIndex++;
        }
        inputStr = inputBuilder.delete(startIndex,endIndex).toString();

        if ("".equals(inputStr)) {
            System.out.println("内容清空");
        }else {
            System.out.println(inputStr);
        }
        return inputStr;
    }


}