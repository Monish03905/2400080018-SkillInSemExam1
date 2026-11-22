# FSAD In-Sem Exam — Hibernate HQL + React Router warm-up

Coursework submission (**2400080018**) for the Full Stack Application Development in-semester lab at KL University.

The repository holds two small exercises:

| Folder / file | Exercise |
| --- | --- |
| `hqlproject/` | Hibernate 5 + MySQL: insert a `Delivery` record, then delete it with an HQL positional-parameter query |
| `App.js` | A standalone React Router demo with Home, Courses and Contact routes |

## 1. Hibernate HQL project

`hqlproject/` mirrors the skill exam: a `Delivery` entity mapped to the `delivery` table, configured in `hibernate.cfg.xml` for a local MySQL database named `fsadexam` (`root` / `root`, `hbm2ddl.auto=update`).

```bash
cd hqlproject
mvn compile
mvn org.codehaus.mojo:exec-maven-plugin:3.1.0:java -Dexec.mainClass=com.klef.fsad.exam.ClientDemo
```

The program inserts one row (`id=1`) and immediately deletes it via:

```java
Query q = session.createQuery("delete from Delivery where id=?1");
q.setParameter(1, 1);
```

## 2. React Router demo

`App.js` is a self-contained routing example — a nav bar and three routes:

```jsx
<Route path="/" element={<h2>Welcome to Home Page</h2>} />
<Route path="/courses" element={<h2>Our Courses Page</h2>} />
<Route path="/contact" element={<h2>Contact Us Page</h2>} />
```

There is no `package.json` at the repository root, so it is a code snippet rather than a runnable app. To try it, create a Vite or Create React App project with `react-router-dom` and use this file as `src/App.js`.

## Structure

```text
App.js                  React Router demo
hqlproject/
  src/main/java/com/klef/fsad/exam/
    Delivery.java       Entity → delivery table
    ClientDemo.java     Insert + HQL delete
  src/main/resources/hibernate.cfg.xml
  pom.xml
```

## Notes

- Create the MySQL database `fsadexam` before running the Hibernate project, or edit the URL in `hibernate.cfg.xml`.
- The Hibernate exercise expects an empty/clean `delivery` table (it inserts a fixed primary key of `1`).
- Lab coursework — not production configuration.
