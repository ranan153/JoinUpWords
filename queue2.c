#include <stdio.h>
#include <stdlib.h>
#include "mylib.h"
#include "queue.h"

typedef struct q_item *q_item;

struct q_item {
    double item;
    q_item next;
};

struct queue {
    q_item first;
    q_item last;
    int length;
};

queue queue_new() {
    queue result = emalloc(sizeof *result);
    return result;
}

queue queue_free(queue q) {
    q_item current = q->first;
    while (current->next != NULL) {
        q->first = current->next;
        free(current);
        current = q->first;
    }
    free(current);
    free(q);
    return q;
}

void enqueue(queue q, double item) {

    if (q->first == NULL) {
        q_item new = emalloc(sizeof *new);
        new->item = item;
        q->first = new;
        q->last = q->first;
        q->length += 1;
    } else {
        q_item new = emalloc(sizeof *new);
        new->item = item;
        q->last->next = new;
        q->last = new;
        q->length += 1;
    }
}

double dequeue(queue q) {
    double d = q->first->item;
    q->first = q->first->next;
    q->length -= 1;
    return d;
}

void queue_print(queue q) {
    q_item current = q->first;
    while (current->next != NULL) {
        printf("%f\n", current->item);
        current = current->next;
    }
    printf("%f\n", current->item);
}

int queue_size(queue q) {
    return q->length;
}
