package com.demo;

/**
 * @author zwj
 * @date 2024/8/29 19:53
 * @desc
 */
public class ReplaceRepeat extends AbstractHandleRepeat {

    public String handleInput(String inputStr, HandleIndex handleIndex) {
        StringBuffer inputBuffer = new StringBuffer(inputStr);
        int startIndex = handleIndex.getStartIndex();
        int endIndex = handleIndex.getEndIndex() + 1;
        String replaceStr = inputStr.substring(startIndex,endIndex);
        char replaceValue = (char) ((replaceStr.charAt(0) - 'a' - 1 + 26) % 26 + 'a');
        String result = null;
        if ((char)replaceStr.charAt(0) == 'a') {
            result = inputBuffer.delete(startIndex, endIndex).toString();
            if("".equals(result)){
                System.out.println("内容清空");
            }else {
                System.out.println(result);
            }
        }else {
            result = inputBuffer.replace(startIndex, endIndex, String.valueOf(replaceValue)).toString();
            System.out.println(result + ","+replaceStr + " is replaced by " + replaceValue);
        }
        return result;
    }
}