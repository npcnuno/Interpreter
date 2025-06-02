load "university.xml" to doc
univ_id = doc @id
cs_dept = doc.department
cs_courses = cs_dept.course
course_count = cs_courses#
instructors = cs_courses->instructor
total_credits = cs_courses->credits++
cs_course_codes = cs_courses->code
first_course_title = cs_courses[0].title
xml = ***
<report univ_id="$univ_id" total_credits="$total_credits" course_count="$course_count">
    <department code="$cs_dept.@code">
        <course$cs_courses name="$code">
            <title>$title</title>
            <instructor>$instructor.name</instructor>
        </course>
    </department>
</report>
***
save xml to "report.xml"