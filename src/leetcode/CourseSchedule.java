package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ych0112xzz on 2016/12/2.
 */
public class CourseSchedule {

    class Course {
        int id;
        int topNum;
        int indegree;
        ArrayList<Course> adjList;

        Course(int id, int topNum, int indegree) {//此题topnum无用
            this.id = id;
            this.topNum = topNum;
            this.indegree = indegree;
            this.adjList = new ArrayList<>();
        }

    }


    /*
    * BFS
    * */
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
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
            for (Course c : course.adjList) {
                if (--c.indegree == 0) {
                    q.offer(c);
                }
            }
        }
        if (count == numCourses) {
            return true;
        }
        return false;
    }*/
    /*
    * DFS
    * */
    int result = 0;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        for (Course course : courses) {
            if (course.indegree == 0) {

                dfs(course);
            }
        }
        if (result == numCourses) {
            return true;
        }
        return false;
    }

    private void dfs(Course course) {
        course.indegree--;
        course.topNum = ++result;
        for (Course c : course.adjList) {
            if (--c.indegree == 0) {
                dfs(c);
            }
        }
    }


/*    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
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
        return count==numCourses?result:new int[0];
    }*/
}
