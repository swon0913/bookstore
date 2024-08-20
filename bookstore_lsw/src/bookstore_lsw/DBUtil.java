package bookstore_lsw;

import java.io.*;
import java.util.*;

class DBUtil {
	
	/*
	 * DBUtil 의 경우 내용이 어렵기도 하고,
	 * 실무에서도 잘 안 쓰일 만한 내용이라
	 * 따로 추가하지 않아도 됨
	 */
	
	public static String filePath = "src/bookstore_lsw/";

    // 데이터를 파일에 추가하는 메서드
    public static void create(String tableName, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + tableName + ".txt", true))) {
        	// 두번째 인자 true 를 통해 파일을 덮어쓰지 않고, 기존 파일에 내용 추가
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("파일 쓰기 오류: " + e.getMessage());
        }
    }

    // 파일에서 모든 데이터를 읽어오는 메서드
    public static List<String> read(String tableName) {
        List<String> dataList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath + tableName + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataList.add(line);
            }
        } catch (IOException e) {
            System.out.println("파일 읽기 오류: " + e.getMessage());
        }
        return dataList;
    }

    // 파일에서 특정 인덱스의 데이터를 업데이트하는 메서드
    public static void update(String tableName, int index, String newData) {
        List<String> dataList = read(tableName);
        if (index >= 0 && index < dataList.size()) {
            dataList.set(index, newData);
            writeAll(tableName, dataList);
        }
    }

    // 파일에서 특정 인덱스의 데이터를 삭제하는 메서드
    public static void delete(String tableName, int index) {
        List<String> dataList = read(tableName);
        if (index >= 0 && index < dataList.size()) {
            dataList.remove(index);
            writeAll(tableName, dataList);
        }
    }

    // 모든 데이터를 파일에 다시 쓰는 메서드 (업데이트/삭제 시 사용)
    private static void writeAll(String tableName, List<String> dataList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath + tableName + ".txt"))) {
            for (String data : dataList) {
                writer.write(data);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("파일 쓰기 오류: " + e.getMessage());
        }
    }
}