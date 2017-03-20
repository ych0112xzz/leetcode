package util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2017/3/20.
 */
public class TopologicalSort {

    class Course {
        int id;
        int topNum;//存放拓扑编号，即该课程被修的顺序（不唯一）
        int indegree;//顶点入度
        ArrayList<Course> adjList;//存储指向当前course所有course

        Course(int id, int topNum, int indegree) {//此题topnum无用
            this.id = id;
            this.topNum = topNum;
            this.indegree = indegree;
            this.adjList = new ArrayList<>();
        }

    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];//存储拓扑排序的顺序
        Course[] courses = new Course[numCourses];
        for (int i = 0; i < numCourses; i++) {
            courses[i] = new Course(i, 0, 0);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int startV = prerequisites[i][0];
            int endV = prerequisites[i][1];
            courses[startV].indegree++;
            courses[endV].adjList.add(courses[startV]);
        }
        Queue<Course> q = new LinkedList<>();
        int count = 0;
        for (Course course : courses) {
            if (course.indegree == 0) {
                q.offer(course);//add()和remove()方法在失败的时候会抛出异常(不推荐)
            }
        }
        while (!q.isEmpty()) {
            Course course = q.poll();
            course.topNum = ++count;
            result[course.topNum-1] = course.id;
            for (Course c : course.adjList) {
                if (--c.indegree == 0) {
                    q.offer(c);
                }
            }
        }
        return count==numCourses?result:new int[0];//判断拓扑排序是否有圈
    }
}
