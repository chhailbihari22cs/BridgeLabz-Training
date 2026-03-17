import java.util.*;


interface EventInfo {
    String getName();
    void print();
}

class BasicDetails {
    private String name;
    private String venue;
    private String schedule;

    BasicDetails(String name, String venue, String schedule) {
        this.name = name;
        this.venue = venue;
        this.schedule = schedule;
    }

    void showBase() {
        System.out.println("Festival Name: " + name);
        System.out.println("Location: " + venue);
        System.out.println("Date: " + schedule);
    }

    String fetchName() {
        return name;
    }
}

/* ---------- specific festival types ---------- */
class MusicEvent implements EventInfo {

    private BasicDetails base;
    private String star;
    private String category;
    private int cost;

    MusicEvent(BasicDetails base, String star, String category, int cost) {
        this.base = base;
        this.star = star;
        this.category = category;
        this.cost = cost;
    }

    public String getName() {
        return base.fetchName();
    }

    public void print() {
        base.showBase();
        System.out.println("Headliner: " + star);
        System.out.println("Music Genre: " + category);
        System.out.println("Ticket Price: " + cost);
    }
}

class FoodEvent implements EventInfo {

    private BasicDetails base;
    private String style;
    private int counter;
    private int entry;

    FoodEvent(BasicDetails base, String style, int counter, int entry) {
        this.base = base;
        this.style = style;
        this.counter = counter;
        this.entry = entry;
    }

    public String getName() {
        return base.fetchName();
    }

    public void print() {
        base.showBase();
        System.out.println("Cuisine: " + style);
        System.out.println("Number of Stalls: " + counter);
        System.out.println("Entry Fee: " + entry);
    }
}

class ArtEvent implements EventInfo {

    private BasicDetails base;
    private String medium;
    private int participants;
    private int charge;

    ArtEvent(BasicDetails base, String medium, int participants, int charge) {
        this.base = base;
        this.medium = medium;
        this.participants = participants;
        this.charge = charge;
    }

    public String getName() {
        return base.fetchName();
    }

    public void print() {
        base.showBase();
        System.out.println("Art Type: " + medium);
        System.out.println("Number of Artists: " + participants);
        System.out.println("Exhibition Fee: " + charge);
    }
}


enum FestivalKind {

    MUSIC {
        EventInfo build(String[] p) {
            BasicDetails b = new BasicDetails(p[2], p[3], p[4]);
            return new MusicEvent(b, p[5], p[6], Integer.parseInt(p[7]));
        }
    },

    FOOD {
        EventInfo build(String[] p) {
            BasicDetails b = new BasicDetails(p[2], p[3], p[4]);
            return new FoodEvent(b, p[5],
                    Integer.parseInt(p[6]),
                    Integer.parseInt(p[7]));
        }
    },

    ART {
        EventInfo build(String[] p) {
            BasicDetails b = new BasicDetails(p[2], p[3], p[4]);
            return new ArtEvent(b, p[5],
                    Integer.parseInt(p[6]),
                    Integer.parseInt(p[7]));
        }
    };

    abstract EventInfo build(String[] p);
}


public class EventConsoleApp {

    private static Map<String, EventInfo> registry = new LinkedHashMap<>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        for (;;) {

            String line = scan.nextLine();
            if (line.equals("EXIT"))
                break;

            String[] tokens = line.split(" ");
            handle(tokens);
        }
    }

    private static void handle(String[] t) {

        switch (t[0]) {

            case "ADD_FESTIVAL":
                FestivalKind kind = FestivalKind.valueOf(t[1]);
                EventInfo obj = kind.build(t);
                registry.put(obj.getName(), obj);
                break;

            case "DISPLAY_DETAILS":
                EventInfo e = registry.get(t[1]);
                if (e != null)
                    e.print();
                break;
        }
    }
}