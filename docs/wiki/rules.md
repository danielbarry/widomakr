# Rules

## Introduction

This document serves to show the expected behaviour as a user of our software
when reporting bugs or making task requests. The purpose for this is:

  * Not wasting developer time and resources
  * Making sure that everybody understands what is required in order to
  register a bug/task

**NOTE:** Please search existing open/closed issues before adding yours! There
is a chance it is already open.

## Basic Layout

The following is the layout for a report:

    Title:      Less than 80 characters, clearly explaining what is needed.
                Being as clear here as possible is the key, otherwise
                developers won't know what's required.
    Body:       Please refer to the relevant bug/feature/task section.
    Assigneess: No one.
    Labels:     "bug" for bug and "enhancement" for feature or task.
    Projects:   Leave blank.
    Milestone:  Leave blank.

## Bugs

Please refer to "Basic Layout" for the basic layout for this section.

For the body, please use the following format:

    # Description

    (Description of the issue here, more verbose than the title if it better
    explains the issue.)

    # Reproduction Steps

    1. (First step)
    (...)
    N. (Last step)

    # Expected Outcome

    (Describe what you expected to see)

    # Actual Outcome

    (Describe how it was different from what you expected)

    # Additional Notes

    (Any other information you think could help)

**Developers:** When accepting the issue, assign yourself and assign a priority
in the form of a `#` at the start of the project title if it is high priority -
please use sparingly.

## Feature Request

For a feature request, the following body is required:

    # Acceptance Criteria

    `[ ]` (First item that signifies the issue is completed)
    (...)
    `[ ]` (Last item)

**Developers:** Please read the "Tasks" section.

## Tasks

**NOTE:** Only tasks created or assigned by developers will be accepted. Please
refer to feature request to start the process of a feature becoming a task.

**Developers:**

Additionally to the "Feature Request" section, the following must be added once
assigned:

    # Tasks

    `[ ]` (First task)
    (...)
    `[ ]` (Last task)

    # Regression Testing

    (A description of how this will be made sure to continue working in the
    future.)
