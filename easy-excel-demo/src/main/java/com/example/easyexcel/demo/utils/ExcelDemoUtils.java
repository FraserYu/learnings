package com.example.easyexcel.demo.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.example.easyexcel.demo.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author fraser
 * @date 2019/10/7 2:41 PM
 */
@Slf4j
public class ExcelDemoUtils {

	/**
	 * 指定阈值
	 * @param consumer
	 * @param threshold
	 * @param <T>
	 * @return
	 */
	public static <T> AnalysisEventListener<T> getListener(Consumer<List<T>> consumer, int threshold) {
		return new AnalysisEventListener<T>() {
			private LinkedList<T> linkedList = new LinkedList<T>();

			@Override
			public void invoke(T t, AnalysisContext analysisContext) {
				linkedList.add(t);
				if (linkedList.size() == threshold){
					consumer.accept(linkedList);
					linkedList.clear();
				}
			}

			@Override
			public void doAfterAllAnalysed(AnalysisContext analysisContext) {
				if (linkedList.size() > 0){
					consumer.accept(linkedList);
				}
			}
		};
	}

	/**
	 * 不指定阈值，阈值默认为10
	 * @param consumer
	 * @param <T>
	 * @return
	 */
	public static <T> AnalysisEventListener<T> getListener(Consumer<List<T>> consumer){
		return getListener(consumer, 10);
	}
}
