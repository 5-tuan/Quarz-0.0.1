package com.djpf.personnel.utils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

public class PinyinUtil {

    public String getUpperStr(String name) {
        if (StringUtils.isNotBlank(name)) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < name.length(); i++) {
                String characters = String.valueOf(name.charAt(i));
                str.append(converterToFirstSpell(characters).toUpperCase().charAt(0));
            }
            return str.toString();
        }
        return "";
    }

    public static String converterToFirstSpell(String str) {
        StringBuilder pinyinName = new StringBuilder();
        char[] nameChar = str.toCharArray();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        for (char characters : nameChar) {
            String string = String.valueOf(characters);
            if (string.matches("[\\u4e00-\\u9fa5]")) {
                try {
                    String[] mPinyinArray = PinyinHelper.toHanyuPinyinStringArray(characters, defaultFormat);
                    pinyinName.append(mPinyinArray[0]);
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pinyinName.append(characters);
            }
        }
        return pinyinName.toString();
    }
}
