import java.util.*;

// Node class for Doubly Linked List (DLL)
class TabNode {
    String url;
    TabNode prev;
    TabNode next;

    TabNode(String url) {
        this.url = url;
    }
}

public class BrowserBuddy {
    private TabNode currentTab = null; // Current active tab/page
    private Stack<String> closedTabs = new Stack<>(); // Stack for closed tabs

    // 1. New Page Open Karna (DLL Insertion)
    public void openPage(String url) {
        TabNode newNode = new TabNode(url);
        if (currentTab == null) {
            currentTab = newNode;
        } else {
            // Naya page current ke aage juda aur purana uska peeche wala bana
            currentTab.next = newNode;
            newNode.prev = currentTab;
            currentTab = newNode; // Current ab naya page hai
        }
        System.out.println("Opened: " + url);
    }

    // 2. Backward Navigation
    public void goBack() {
        if (currentTab != null && currentTab.prev != null) {
            currentTab = currentTab.prev;
            System.out.println("Back to: " + currentTab.url);
        } else {
            System.out.println("No back history!");
        }
    }

    // 3. Forward Navigation
    public void goForward() {
        if (currentTab != null && currentTab.next != null) {
            currentTab = currentTab.next;
            System.out.println("Forward to: " + currentTab.url);
        } else {
            System.out.println(" No forward history!");
        }
    }

    // 4. Tab Close Karna (Stack mein push karna)
    public void closeCurrentTab() {
        if (currentTab == null) return;

        System.out.println("Closing: " + currentTab.url);
        closedTabs.push(currentTab.url); // Stack mein save kar liya

        // Pointers update karna
        if (currentTab.prev != null) {
            currentTab = currentTab.prev;
            currentTab.next = null; // Aage ka rasta khatam
        } else {
            currentTab = null;
        }
    }

    // 5. Restore Closed Tab (Stack se pop karna)
    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println(" No tabs to restore!");
            return;
        }
        String restoredUrl = closedTabs.pop();
        System.out.print("Restoring... ");
        openPage(restoredUrl);
    }

    public static void main(String[] args) {
        BrowserBuddy browser = new BrowserBuddy();

        browser.openPage("google.com");
        browser.openPage("github.com");
        browser.openPage("stackoverflow.com");

        browser.goBack();    // Github
        browser.goForward(); // StackOverflow
        
        browser.closeCurrentTab(); // Closes StackOverflow
        browser.restoreTab();      // Re-opens StackOverflow
    }
}
